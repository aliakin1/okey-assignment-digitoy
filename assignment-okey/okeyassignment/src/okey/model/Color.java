package okey.model;

public enum Color {

	yellow(0),
	red(1),
	black(2),
	blue(3);

	private final int value;

	private Color(int value) {
		this.value = value;
	}

	public static Color getEnum(int value) {
		for (Color durum : Color.values()) {
			if (durum.getValue() == value) {
				return durum;
			}

		}
		return null;

	}

	public int getValue() {
		return value;
	}
}
