package isp;

class SimplePrinter implements SmartPrinter {
    public void print() { System.out.println("프린트 완료");  }
    public void fax() { /* 사용 안 함 */ } // 불필요한 구현 강제
}
