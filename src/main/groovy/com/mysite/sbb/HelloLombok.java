package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Setter
@RequiredArgsConstructor
@Getter
public class HelloLombok {
    private final String hello;
    private final int lombok;
//  2. @RequiredArgsConstructor를 사용하면
//    final를 보고 생성자를 그에 알맞게 자동으로 만들어준다
//    없었다면? 이렇게 직접 만들어줘야 했을 것이다
//    public HelloLombok(String hello, int lombok) {
//        this.hello = hello;
//        this.lombok = lombok;
//    }

//    1. 만일 @Getter, @Setter annotation이 없었다면
//    public void setHello(String hello) {
//        this.hello = hello;
//    }
//
//    public String getHello() {
//        return this.hello;
//    }

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로", 5);
//        helloLombok.setHello("헬로");
//        helloLombok.setLombok(5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
