package exam2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalDate {

	public static void main(String[] args) {
		System.out.println("请输入日期：");
		Scanner input = new Scanner(System.in);
		String date = input.nextLine();
		if(!isDate(date)){
			System.out.println("您输入的日期不存在");
		}else{
			String[] split = date.split("-");
			String years = split[0];
			String days = split[2];
			String months = split[1];
			int year = Integer.parseInt(years);
			int month =Integer.parseInt(months);
			int day =Integer.parseInt(days);
			nextDate(year,month,day);
		}
	}
	/**
	 * 输出下一天日期
	 */
	private static void nextDate(int year, int month, int day) {
		//31天
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day>=1&&day<31){//在正常范围内直接天数+1
				day+=1;
			}else{
				if(month==12&&day==31){//一年最后一天就下一年
					year+=1;
					day = 1;
					month = 1;
				}else if(month!=12&&day==31){//正常月份最后一天就月份+1
					month+=1;
					day = 1;
				}
			}
		}else if(month==2){//闰月
			if(isLeapYear(year)){//闰年
				if(day>=1&&day<29){
					day+=1;
				}else if(day==29){
					month+=1;
					day = 1;
				}
			}else{//平年
				if(day>=1&&day<28){
					day+=1;
				}else if(day==28){
					month+=1;
					day = 1;
				}
			}
		}else if(month==4||month==6||month==9||month==11){//30天
			if(day>=1&&day<30){//在正常范围内直接天数+1
				day+=1;
			}else if(day==30){//月份最后一天 月份+1
				month+=1;
				day = 1;
			}
		}
		String sm = month<10?"0"+month:month+"";
		String sd = day<10?"0"+day:day+"";
		System.out.println("下一天为 "+year+"-"+sm+"-"+sd);
	}

	/**
	 * 判断是否闰年
	 */
	private static boolean isLeapYear(int year){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)return true;
		return false;
	}
	
	 /** 
     * 用正则判断日期格式和范围 
     */  
	private static boolean isDate(String date)  
    {  
       
        String rexp = "((^\\d{4}-0\\d{1}-[0-3]{1}\\d{1})|(^\\d{4}-1[0-2]{1}-[0-3]{1}\\d{1}))$";  
          
        Pattern pat = Pattern.compile(rexp);    
          
        Matcher mat = pat.matcher(date);    
          
        boolean dateType = mat.matches();  

        return dateType;  
    }  

}
