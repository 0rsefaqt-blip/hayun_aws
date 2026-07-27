package day03;

import java.util.Scanner;

public class Ex13_과제 {

   public static void main(String[] args) {
      /* 1번. 100이하의 소수를 출력하는 코드를 작성하세요.
       * 2 3 5 7 11 13 ... 97
       * - 힌트 : 2중 반복문. 소수 판별예제 참고
       */
      int count =0;
      for(int a = 1; a <=100; a++) {
         count = 0;
         for(int b = 1; b<=a; b++) {
            if(a%b==0) {
               ++count;
               
            }
         }
         
         if(count ==2) {
            System.out.println(a+"는 소수입니다.");
         }
      }
      
      /* 2번. 다음과 같이 출력되도록 코드를 작성하세요.
       * 2-1.
       * *
       * **
       * ***
       * ****
       * *****
       * 첫째줄부터 다섯째줄까지 별이 1개 두개 다섯개 나오기
       */
      for(int c = 1; c <=5; c++) {
         for(int d = 1; d<=c; d++) {
            System.out.print("*");
         }
         System.out.println();
      }
      
      
      /* 2-2. 
       *     *
       *    **
       *   ***
       *  ****
       * *****
       */
      for(int c = 1; c <=5; c++) {
         for(int e = 1; e<=5-c; ++e) {
            System.out.print(' ');            
         }
         for(int d = 1; d<=c; d++) {
            System.out.print("*");
         }
         System.out.println();
      }
      /* 2-3.
       *     *
       *    ***
       *   *****
       *  *******
       * *********
       */
      for(int c = 1; c <=5; c++) {
         for(int e = 1; e<=5-c; ++e) {
            System.out.print(' ');            
         }
         for(int d = 1; d<=9-2*(5-c); d++) { //9-8 9-6 9-4 9-2(5-c)
            System.out.print("*");
         }
         System.out.println();
      }
      
      /* 3번. 두 정수가 서로소 관계인지 판별하는 코드를 작성하세요.
       * 서로소는 두 정수의 최대 공약수가 1인 두 수의 관계
       * 예시
       * 정수 입력 : 10
       * 정수 입력 : 7
       * 10과 7은 서로소입니다.
       * 예시
       * 정수 입력 : 10
       * 정수 입력 : 8
       * 10과 8은 서로소가 아닙니다.
       * - 힌트 : 최대 공약수 예제 참고
       */ 
//      Scanner scan = new Scanner(System.in);
//
//      System.out.print("정수1을 입력하세요. : ");
//      int num1 = scan.nextInt();
//      System.out.print("정수2를 입력하세요. : ");
//      int num2 = scan.nextInt();
//      for(int f = 2; f<=num1 && f<=num2; f++) {
//         if(num1%f ==0 && num2%f ==0) {            
//            System.out.println(num1+" 과 "+num2+" 는 서로소가 아닙니다");
//         }
//         else {
//            System.out.println(num1+" 과 "+num2+" 는 서로소입니다");
//         }
//         
//      }
       
      /* 4번. 아래와 같이 출력되도록 코드를 작성하세요.
       * 1 2 3 4
       * 8 7 6 5
       * 9 10 11 12
       * 16 15 14 13
       * */
      int h;
      for(int g = 1; g<=4; ++g) {
         if(g%2 != 0) {
            for(h =4*g-3; h<=4*g; ++h) {
               System.out.print(h+" ");
            }
         }
         else {
            for( h=4*g; h >=4*g-3; --h) {
               System.out.print(h + " ");         
            }
         }
         System.out.println();
      }
   }

}