package com.test.demo.vo;

public class ResponseView {
  private int code;
  private Object body;
  
  public ResponseView() {
    code = 0;
  }
  
  public ResponseView(int code) {
    this.code = code;
  }
  
  public void setBody(Object body) {
    this.body = body;
  }
  
  public void setCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public Object getBody() {
    return body;
  }
  
  
}
