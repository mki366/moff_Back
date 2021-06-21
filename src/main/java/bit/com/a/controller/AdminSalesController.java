package bit.com.a.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import bit.com.a.dto.DeliveryCheckDto;
import bit.com.a.dto.OrderBuyDto;
import bit.com.a.dto.OrderDetailDto;

import bit.com.a.dto.AdminDto;
import bit.com.a.dto.PurchasesDto;
import bit.com.a.service.AdminSalesService;

@RestController
public class AdminSalesController {

   @Autowired
   AdminSalesService service;
   
   
   @RequestMapping(value = "/salesByPeriod", method = RequestMethod.POST)
   public int[] salesByPeriod() {
      System.out.println("AdminSalesController salesByPeriod()");
      int Array[] = new int[5];
      
      Array[0] = service.dailySales();
      Array[1] = service.monthlySales();
      Array[2] = service.annualSales();
      Array[3] = service.totalSales();
      return Array;
   }
   
   @RequestMapping(value = "/selDailySales", method = RequestMethod.POST)
   public List<PurchasesDto> selDailySales(String yearmonth) {
      System.out.println("AdminSalesController selDailySales()"); 

      if(yearmonth==null) {
         Date date = new Date();
      
         SimpleDateFormat df = new SimpleDateFormat("yy/MM");
         yearmonth = df.format(date);
      }
      
      List<PurchasesDto> dlist = service.selDailySales(yearmonth);
      return dlist;
   }
   
   @RequestMapping(value = "/selMonthlySales", method = RequestMethod.POST)
   public List<PurchasesDto> selMonthlySales(String year) {
      System.out.println("AdminSalesController selMonthlySales()"); 

      if(year==null) {
         Date date = new Date();
         SimpleDateFormat df = new SimpleDateFormat("yy");
         year = df.format(date);
      }
      
      List<PurchasesDto> mlist = service.selMonthlySales(year);
      return mlist;
   }
   
   @RequestMapping(value = "/selAnnualSales", method = RequestMethod.POST)
   public List<PurchasesDto> selAnnualSales() {
      System.out.println("AdminSalesController selAnnualSales()"); 

      List<PurchasesDto> alist = service.selAnnualSales();
      return alist;
   }
   
   @RequestMapping(value = "/salesReport", method = RequestMethod.POST)
   public List<AdminDto> salesReport(String year, String month) {
      System.out.println("AdminSalesController salesReport()"); 
      List<AdminDto> list = service.salesReport(year + month);
      return list;
   }
   
   
   @RequestMapping(value = "/annualSalesChart", method = RequestMethod.POST)
   public List<PurchasesDto> annualSalesChart(String year) {
      System.out.println("AdminSalesController annualSalesChart()"); 
      List<PurchasesDto> list = service.annualSalesChart(year);
      return list;
   }
   
   @RequestMapping(value = "/annualAccumChart", method = RequestMethod.POST)
   public List<AdminDto> annualAccumChart(String year) {
      System.out.println("AdminSalesController annualAccumChart()"); 
      List<AdminDto> list = service.annualAccumChart(year);
      return list;
   }
   
   @RequestMapping(value = "/monthlyVarChart", method = RequestMethod.POST)
   public List<AdminDto> monthlyVarChart() {
      System.out.println("AdminSalesController monthlyVarChart()"); 
      List<AdminDto> list = service.monthlyVarChart();
      return list;
   }
   
   @RequestMapping(value = "/weeklyPie", method = RequestMethod.POST)
   public List<PurchasesDto> weeklyPie() {
      System.out.println("AdminSalesController weeklyPie()"); 
      List<PurchasesDto> list = service.weeklyPie();
      return list;
   }
   
   //주문 건 수 - 오늘 
   @RequestMapping(value = "/CountDailySales", method = RequestMethod.GET)
   public int CountDailySales() {
      System.out.println("AdminSalesController CountDailySales()");
      return service.CountDailySales();
   }
   
   //주문 건 수 - 오늘 
   @RequestMapping(value = "/CountMonthlySales", method = RequestMethod.GET)
   public int CountMonthlySales() {
      System.out.println("AdminSalesController CountMonthlySales()");
      return service.CountMonthlySales();
   }
   
   //주문 건 수 - 올해
   @RequestMapping(value = "/CountAnnualSales", method = RequestMethod.GET)
   public int CountAnnualSales() {
      System.out.println("AdminSalesController CountAnnualSales()");
      return service.CountAnnualSales();
   }
   
   //주문 건 수 - 총
   @RequestMapping(value = "/CountTotalSales", method = RequestMethod.GET)
   public int CountTotalSales() {
      System.out.println("AdminSalesController CountTotalSales()");
      return service.CountTotalSales();
   }

 
	//배송중
		@RequestMapping(value = "/inDelivery", method = RequestMethod.GET)
		public int inDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController inDelivery()"+dto.getCheckDate());
			return service.inDelivery(dto);
		}

		//배송 완료
		@RequestMapping(value = "/delivered", method = RequestMethod.GET)
		public int delivered(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController delivered()"+dto.getCheckDate());
			return service.delivered(dto);
		}
		
		//배송 전
		@RequestMapping(value = "/beforeDelivery", method = RequestMethod.GET)
		public int beforeDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController beforeDelivery()"+dto.getCheckDate());
			return service.beforeDelivery(dto);
		}
		
		//배송 수락
		@RequestMapping(value = "/acceptDelivery", method = RequestMethod.GET)
		public int acceptDelivery(DeliveryCheckDto dto) {
			System.out.println("AdminSalesController acceptDelivery()"+dto.getCheckDate());
			return service.acceptDelivery(dto);
		}
		//구매 건수
		@RequestMapping(value = "/orderBuyDate", method = RequestMethod.GET)
		public int orderBuyDate(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderBuyDate()"+dto.getObDate());
			return service.orderBuyDate(dto);
		}
		//구매 건수
		@RequestMapping(value = "/orderBuyPriceDate", method = RequestMethod.GET)
		public int orderBuyPriceDate(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderBuyPriceDate()"+dto.getObDate());
			return service.orderBuyPriceDate(dto);
		}
		
		//반품 갯수
		@RequestMapping(value = "/orderDetailTB", method = RequestMethod.GET)
		public int orderDetailTB(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderDetailTB()"+dto.getObDate());
			return service.orderDetailTB(dto);
		}
		//교환 갯수
		@RequestMapping(value = "/orderDetailEX", method = RequestMethod.GET)
		public int orderDetailEX(OrderBuyDto dto) {
			System.out.println("AdminSalesController orderDetailEX()");
			return service.orderDetailEX(dto);
		}

		//년도별 주문 건수 
		@RequestMapping(value = "/SearchAnnualSales", method = RequestMethod.GET)
		public int[] SearchAnnualSales(OrderBuyDto dto) {
			System.out.println("AdminSalesController SearchAnnualSales()"+dto.getObDate());
			int result[]=new int[12];
			for(int i=1; i<13;i++) {
				String month="";
				String date="";
				if(i<10) {
					month='0'+Integer.toString(i);
					System.out.println("1월 부터 9월:"+month);
				}
				else {
					month=Integer.toString(i);
				}
				date=dto.getObDate()+'/'+month;
				
				OrderBuyDto sdto= new OrderBuyDto(date);
				result[i-1]=service.SearchAnnualSales(sdto);
				System.out.println("**날짜"+date+"의 결과 :"+result[i-1]+"**");
			}
			return result;
		}
		
		
		//지역별 주문 건수 
		@RequestMapping(value = "/SearchLocalSales", method = RequestMethod.GET)
		public String[] SearchLocalSales() {
			System.out.println("AdminSalesController SearchLocalSales()");
			String str[] = service.SearchLocalSales();
			String str2[] = service.SearchLocalCountSales();
			String re[]= new String[5];
			for(int i=0; i<str.length;i++) {
				System.out.println(str2[i]);
				if(str[i].contains("제주")) {
					re[i]="제주";
				}else if(str[i].contains("서울")) {
					re[i]="서울";
				}else if(str[i].contains("부산")) {
					re[i]="부산";
				}else if(str[i].contains("대구")) {
					re[i]="대구";
				}else if(str[i].contains("인천")) {
					re[i]="인천";
				}else if(str[i].contains("광주")) {
					re[i]="광주";
				} else if(str[i].contains("대전")) {
					re[i]="대전";
				}else if(str[i].contains("울산")) {
					re[i]="울산";
				}else if(str[i].contains("세종")) {
					re[i]="세종";
				}else if(str[i].contains("경기")) {
					re[i]="경기";
				}else if(str[i].contains("강원")) {
					re[i]="강원";
				}else if(str[i].contains("충청북도")) {
					re[i]="충청북도";
				}else if(str[i].contains("충청남도")) {
					re[i]="충청남도";
				}else if(str[i].contains("전라북도")) {
					re[i]="전라북도";
				}else if(str[i].contains("경상북도")) {
					re[i]="경상북도";
				}else if(str[i].contains("경상남도")) {
					re[i]="경상남도";
				}
				re[i] =re[i]+","+str2[i];
			}
			for(int i=0; i<re.length;i++) {
				System.out.println(re[i]);
			}
			return re;
		}
}

   


