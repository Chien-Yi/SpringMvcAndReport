package app.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.config.model.Product;
import app.web.service.ProductService;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class Main {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ProductService productService;
	
	private final Logger logger = LogManager.getLogger();

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		
		return "redirect:/product/list";
	}
	
	
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public String showAllProduct(Model model) {
		
		logger.debug(productService.findAll().size());
		
		model.addAttribute("products",productService.findAll());
		
		return "product/list";
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		Product product = productService.findById(new Integer(id));
		if (product == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("product", product);

		return "product/show";

	}
	// show add user form
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String showAddProductForm(Model model) {

		logger.debug("showAddProductForm()");

		Product product = new Product();

		model.addAttribute("productForm", product);

		return "product/productForm";

	}
	
	// show update form
	@RequestMapping(value = "/product/{id}/update", method = RequestMethod.GET)
	public String showUpdateProductForm(@PathVariable("id") int id, Model model) {
	
		logger.debug("showUpdateUserForm() : {}", id);
	
		Product product = productService.findById(id);
		model.addAttribute("productForm", product);
		
		return "product/productForm";
	
	}
	
	// delete user
	@RequestMapping(value = "/product/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id, 
		final RedirectAttributes redirectAttributes) {

		logger.debug("deleteUser() : {}", id);

		productService.delete(id);
		
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		
		return "redirect:/product/list";

	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("productForm") Product product,
			BindingResult result, Model model, 
			final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", product.getProductId());

		if (result.hasErrors()) {
			//populateDefaultModel(model);
			return "product/list";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			
			if(product.getProductId() == 0){
			  redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
			  redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}
			
			logger.debug(product.getProductId());
			logger.debug(product.getName());
			
			productService.saveOrUpdate(product);
			
			return "redirect:/product/" + product.getProductId();

		}

	}
	//@PathVariable("file_name") String fileName
	@RequestMapping(value = "/product/files", method = RequestMethod.GET,produces = "application/pdf")
	@ResponseBody
	public FileSystemResource getFile() throws JRException {
		String source = servletContext.getRealPath("/WEB-INF/resources/report/templete/report1.jasper");
		String workdir = servletContext.getRealPath("/WEB-INF/resources/report/workdir/report1.pdf");
		
		JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(source);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("local","test");

		
		//產出報表
        //JasperPrint print = JasperFillManager.fillReport(report,parameters,new JREmptyDataSource());
		JRDataSource ds = new JRTableModelDataSource(productService.getModel());
		parameters.put(JRParameter.REPORT_DATA_SOURCE,ds);
		
		JasperPrint print = JasperFillManager.fillReport(report,parameters,ds);
		
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, workdir);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
        exporter.exportReport();
		
	    return new FileSystemResource(workdir); 
	}

}
