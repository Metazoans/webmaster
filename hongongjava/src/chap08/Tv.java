package chap08;

public class Tv implements RemoteControl{
	//필드
	private int volume;
	
	//생성자
	
	//메소드
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLOUME) this.volume = RemoteControl.MAX_VOLOUME;
		else if(volume < RemoteControl.MIN_VOLOUME) this.volume = RemoteControl.MIN_VOLOUME;
		else this.volume = volume;
		
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}

}
