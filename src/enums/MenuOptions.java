package enums;

public enum MenuOptions {
	
	ENTER('E', "(E)nter Text"),
	SAVE('S', "(S)ave Text"),
	READ('R', "(R)ead Text"),
	QUIT('Q', "(Q)uit");
	
	private char c;
	private String menuName;
	
	MenuOptions(char c, String menuName) {
		this.c = c;
		this.menuName = menuName;
	}
	
	public char getC() {
		return c;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public static MenuOptions getMatchingOption(char c) {
		for(MenuOptions option : MenuOptions.values()) {
			if(option.getC() == c) return option;
		}
		return ENTER;
	}

}
