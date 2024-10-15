package chap08;

public interface RemoteControl {
	//상수
	public int MAX_VOLOUME = 10;
	public int MIN_VOLOUME = 0;
	
	//추상 메소드
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
}
