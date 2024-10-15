package 김선용;

public class Account {
	//필드
	private String ano;
	private String owner;
	private int balence;
	
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	//생성자
	
	//메소드
	//setter -> 0이면 성공, (1, 2, 3)이면 번호, 계좌주, 초기 입금 각각에서 실패
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalence() {
		return balence;
	}
	public boolean setBalence(int balence) {
		if(balence > MAX_BALANCE || balence < MIN_BALANCE) {
			return false;
		}
		this.balence = balence;
		return true;
	}
	public void addBalence(int balence) { //예금
		int result = this.balence + balence;
		if(result > 1000000 && balence >= 0) {
			System.out.println("계좌가 가득 찼습니다.");
			return;
		}
		this.balence = result;
		System.out.println("예금이 성공되었습니다.");
	}
	public void minusBalence(int balence) { //출금
		int result = this.balence - balence;
		if(result < 0 && balence >= 0) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		this.balence = result;
		System.out.println("출금이 성공되었습니다.");
	}
}
