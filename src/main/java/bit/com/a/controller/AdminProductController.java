package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.ColorDto;
import bit.com.a.dto.ProductDto;
import bit.com.a.dto.ProductImgDto;
import bit.com.a.service.AdminProductService;

@RestController
public class AdminProductController {

	@Autowired
	AdminProductService service;
	
	@Autowired
	ServletContext servlectContext;
	
	
	@RequestMapping(value = "/productRegi", method = RequestMethod.POST)
	public String productRegi(@ModelAttribute ProductDto product,
								ColorDto colorDto, ProductImgDto img, String color2, String imgInfo,
								@RequestParam("fileload1")
								MultipartFile fileload1,
								@RequestParam("fileload2")
								MultipartFile fileload2,
								@RequestParam("fileload3")
								MultipartFile fileload3,
								HttpServletRequest req) {
		
		System.out.println("productRegi() Controller");
		
		String uploadPath = req.getServletContext().getRealPath("/adminProduct");
		
		String filename = fileload1.getOriginalFilename();					// ���몴 �씠誘몄�
		String filepath1 = uploadPath + File.separator + filename;
			
		String imgFilename = fileload2.getOriginalFilename();				// �긽�꽭 �씠誘몄�
		String filepath2 = uploadPath + File.separator + imgFilename;
		
		String colorFilename = fileload3.getOriginalFilename();				// 而щ윭 �씠誘몄�
		String filepath3 = uploadPath + File.separator + colorFilename;	
		
		System.out.println("------�뙆�씪�뾽濡쒕뱶 寃쎈줈------");
		System.out.println("filepath1" + filepath1);
		System.out.println("filepath2" + filepath2);
		System.out.println("filepath3" + filepath3);
		
		// product table �엯�젰
		String category = product.getCategory();
		String subCategory	= product.getSubCategory();
		String prodName = product.getProdName();
		String color = product.getColor();
		String prodOption = product.getProdOption();
		String info = product.getInfo();
		int weight = product.getWeight();
		int oriPrice = product.getOriPrice();
		int price = product.getPrice();
		int quantity = product.getQuantity();
		int deliveryCost = product.getDeliveryCost();
		
		ProductDto productDto =new ProductDto(category, subCategory, prodName, color, prodOption, info, weight, oriPrice, price, quantity, deliveryCost, filename);
		boolean a = service.productRegi(productDto);
		System.out.println("--------!!!!!!!!!" + productDto);
		
		
		if(a == true) {
			System.out.println("productDto succ");
		}else {
			System.out.println("productDto err");
		}
		
		
		// color table �엯�젰
		int prodNum = productDto.getProdNum();
		colorDto.setProdNum(prodNum);
		colorDto.setColor(color2);
		colorDto.setColorFilename(colorFilename);
		System.out.println("----------------------"+colorDto);
		
		boolean b = service.colorRegi(colorDto);
		if(b == true) {
			System.out.println("colorDto succ");
		}else {
			System.out.println("colorDto err");
		}
		
		// productImg table �엯�젰
		img.setProdNum(prodNum);
		img.setInfo(imgInfo);
		img.setImgFilename(imgFilename);
		System.out.println(img);
		
		boolean c = service.imgRegi(img);
		if(c == true) {
			System.out.println("imgDto succ");
		}else {
			System.out.println("imgDto err");
		}
		
		
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath1)));
			BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
			BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3)));
			
			os.write(fileload1.getBytes());
			os2.write(fileload2.getBytes());
			os3.write(fileload3.getBytes());
			
			os.close();
			os2.close();
			os3.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return "NO";
		}
		
		return "YES";
		
	}
	
	
	// �긽�뭹由ъ뒪�듃
	@RequestMapping(value = "/adminProductList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductDto> adminProductList(ProductDto product){
		System.out.println("adminProductList() Controller");
		
		int sn = product.getPage();
		System.out.println("�럹�씠吏��솗�씤: " + sn);
		
		int start = sn * 10 + 1;
		int end = (sn + 1) *10;
		
		product.setStart(start);
		product.setEnd(end);
		
		System.out.println("search" + product.getSearch());
		System.out.println("choice" + product.getChoice());
		
		List<ProductDto> list = service.adminProductList(product);
		
		return list;
	}
		
	// 珥앹닔 adminProductCount
	@RequestMapping(value = "/adminProductCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int adminProductCount(ProductDto product) {
		int count = service.adminProductCount(product);
		System.out.println("adminProductList Count: " + count);
		
		int pagenum = count/10;
		if((count%10)>0) {
			pagenum = pagenum +1;
		}
		
		System.out.println(" 由ъ뒪�듃 �럹�씠吏� 媛��닔 �솗�씤: " + pagenum);
		return pagenum;
	}
		
	// �뵒�뀒�씪 "adminProductDetail"
	@RequestMapping(value = "/adminProductDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public ProductDto adminProductDetail(int prodNum) {
		System.out.println("adminProductDetail() Controller");
		
		ProductDto dto = service.adminProductDetail(prodNum);
		
		return dto;
	}
		
	// �뵒�뀒�씪 �씠誘몄� adminImgDetail
	@RequestMapping(value = "/adminImgDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductImgDto> adminImgDetail(int prodNum){
		System.out.println("adminImgDetail() Controller");
		
		List<ProductImgDto> list = service.adminImgDetail(prodNum);
		System.out.println("imgDetail ProdNum: " + prodNum + list);
		
		return list;
	}
		
	// �뵒�뀒�씪 而щ윭 adminColorDetail
	@RequestMapping(value = "/adminColorDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ColorDto> adminColorDetail(int prodNum){
		System.out.println("adminColorDetail() Controller");
		
		List<ColorDto> list = service.adminColorDetail(prodNum);
		
		return list;
	}
	

	// �씠誘몄�異붽� addImage
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ColorDto colorDto, ProductImgDto img, 
							@RequestParam("fileload2")
							MultipartFile fileload2,
							@RequestParam("fileload3")
							MultipartFile fileload3,
							HttpServletRequest req) {
		
		System.out.println("productRegi() Controller");
		
		String uploadPath = req.getServletContext().getRealPath("/adminProduct");
			
		String imgFilename = fileload2.getOriginalFilename();				// �긽�꽭 �씠誘몄�
		String filepath2 = uploadPath + File.separator + imgFilename;
		
		String colorFilename = fileload3.getOriginalFilename();				// 而щ윭 �씠誘몄�
		String filepath3 = uploadPath + File.separator + colorFilename;	
		
		System.out.println("------�뙆�씪�뾽濡쒕뱶 寃쎈줈------");
		System.out.println("filepath2" + filepath2);
		System.out.println("filepath3" + filepath3);
		
		// color table �엯�젰
		int prodNum = colorDto.getProdNum();
		String color = colorDto.getColor();
		
		boolean b = service.addColor(new ColorDto(prodNum, color, colorFilename));
		if(b == true) {
			System.out.println("colorDto succ");
		}else {
			System.out.println("colorDto err");
		}
		
		// productImg table �엯�젰
		img.setProdNum(prodNum);
		String info = img.getInfo();
		
		boolean c = service.addImage(new ProductImgDto(prodNum, info, imgFilename));
		if(c == true) {
			System.out.println("imgDto succ");
		}else {
			System.out.println("imgDto err");
		}
		
		
		try {
			BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
			BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3)));
			
			os2.write(fileload2.getBytes());
			os3.write(fileload3.getBytes());
			
			os2.close();
			os3.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return "NO";
		}
		
		return "YES";
		
	}

	// �닔�젙�뿉�꽌 �뵒�뀒�씪遺덈윭�삤湲� getAdminProduct
	@RequestMapping(value = "/getAdminProduct", method = {RequestMethod.GET, RequestMethod.POST})
	public ProductDto getAdminProduct(int prodNum) {
		System.out.println("getAdminProduct() Controller");
		
		ProductDto dto = service.getAdminProduct(prodNum);
		
		return dto;
	}
	
 	// �닔�젙�뿉�꽌 �씠誘몄� 遺덈윭�삤湲� getAdminImgae
	@RequestMapping(value = "/getAdminImgae", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductImgDto> getAdminImgae(int prodNum){
		System.out.println("getAdminImgae() Controller");
		
		List<ProductImgDto> list = service.getAdminImgae(prodNum);
		System.out.println("getAdminImgae ProdNum: " + prodNum + list);
		
		return list;
	}
	
 	// �닔�젙�뿉�꽌 而щ윭 getAdminColor
	@RequestMapping(value = "/getAdminColor", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ColorDto> getAdminColor(ColorDto colorDto){
		System.out.println("getAdminColor() Controller");
		
		List<ColorDto> list = service.getAdminColor(colorDto);
		
		return list;
	}
	
	// �긽�뭹�궘�젣
	@RequestMapping(value = "/delAdminColor", method = {RequestMethod.GET, RequestMethod.POST})
	public String delAdminColor(int prodNum) {
		System.out.println("delProduct() Controller");
		
		if(service.delAdminColor(prodNum)== true) {
			service.delAdminImg(prodNum);
			service.delAdminProduct(prodNum);
			return "YES";
		}else {
			return "NO";
		}
	}
	
	
	// �옱怨� 由ъ뒪�듃
	@RequestMapping(value = "/stockList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<ProductDto> stockList(ProductDto product){
		System.out.println("stockList() Controller");
		
		int sn = product.getPage();
		System.out.println("stockList �럹�씠吏��솗�씤: " + sn);
		
		int start = sn * 10 + 1;
		int end = (sn + 1) *10;
		
		product.setStart(start);
		product.setEnd(end);
		
		System.out.println("search" + product.getSearch());
		
		List<ProductDto> list = service.stockList(product);
		
		return list;
	}
	
	// 珥앹닔 adminProductCount
	@RequestMapping(value = "/stockListCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int stockListCount(ProductDto product) {
		int count = service.stockListCount(product);
		System.out.println("stockListCount Count: " + count);
		
		int pagenum = count/10;
		if((count%10)>0) {
			pagenum = pagenum +1;
		}
		
		System.out.println("stockList 由ъ뒪�듃 �럹�씠吏� 媛��닔 �솗�씤: " + pagenum);
		return pagenum;
	}
		
	
	// �옱怨� �닔�웾 蹂�寃�
	@RequestMapping(value = "/stockUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public String stockUpdate(ProductDto product) {
		System.out.println("stockUpdate() Controller");
		
		if(service.stockUpdate(product)==true) {
			System.out.println("stockUpdate" + product);
			return "YES";
		}else {
			return "NO";
		}
	}
	
	// �떎�넑//////////////////////////////
	
	// 硫붿씤 �긽�뭹 由ъ뒪�듃 (議고쉶�닔�닚 )
	   @RequestMapping(value = "/mainRcList", method = {RequestMethod.GET, RequestMethod.POST})
	   public List<ProductDto> mainRcList(ProductDto product){
	      System.out.println("mainRcList() " + new Date());

	      List<ProductDto> list = service.mainRcList(product);
	      return list;
	      
	   }
	
		@RequestMapping(value = "/rCount", method = RequestMethod.GET)
		public int rCount() {

			int rcount = service.rCount();
			return rcount;
	
		}
	
		@RequestMapping(value = "/catelist", method = {RequestMethod.GET, RequestMethod.POST})
		   public List<ProductDto> catelist(ProductDto product){
		      System.out.println("catelist() " + new Date());

		      List<ProductDto> list = service.catelist(product);
		      return list;
		      
		   }
		
		@RequestMapping(value = "/prodlist", method = {RequestMethod.GET, RequestMethod.POST})
		public List<ProductDto> prodlist(ProductDto product){
			System.out.println("prodlist() " + new Date());
			
			List<ProductDto> list = service.prodlist(product);
			return list;
			
		}
	
}








