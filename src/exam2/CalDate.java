package exam2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalDate {

	public static void main(String[] args) {
		System.out.println("���������ڣ�");
		Scanner input = new Scanner(System.in);
		String date = input.nextLine();
		if(!isDate(date)){
			System.out.println("����������ڲ�����");
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
	 * �����һ������
	 */
	private static void nextDate(int year, int month, int day) {
		//31��
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day>=1&&day<31){//��������Χ��ֱ������+1
				day+=1;
			}else{
				if(month==12&&day==31){//һ�����һ�����һ��
					year+=1;
					day = 1;
					month = 1;
				}else if(month!=12&&day==31){//�����·����һ����·�+1
					month+=1;
					day = 1;
				}
			}
		}else if(month==2){//����
			if(isLeapYear(year)){//����
				if(day>=1&&day<29){
					day+=1;
				}else if(day==29){
					month+=1;
					day = 1;
				}
			}else{//ƽ��
				if(day>=1&&day<28){
					day+=1;
				}else if(day==28){
					month+=1;
					day = 1;
				}
			}
		}else if(month==4||month==6||month==9||month==11){//30��
			if(day>=1&&day<30){//��������Χ��ֱ������+1
				day+=1;
			}else if(day==30){//�·����һ�� �·�+1
				month+=1;
				day = 1;
			}
		}
		String sm = month<10?"0"+month:month+"";
		String sd = day<10?"0"+day:day+"";
		System.out.println("��һ��Ϊ "+year+"-"+sm+"-"+sd);
	}

	/**
	 * �ж��Ƿ�����
	 */
	private static boolean isLeapYear(int year){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)return true;
		return false;
	}
	
	 /** 
     * �������ж����ڸ�ʽ�ͷ�Χ 
     */  
	private static boolean isDate(String date)  
    {  
       
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";  
          
        Pattern pat = Pattern.compile(rexp);    
          
        Matcher mat = pat.matcher(date);    
          
        boolean dateType = mat.matches();  

        return dateType;  
    }  

}
