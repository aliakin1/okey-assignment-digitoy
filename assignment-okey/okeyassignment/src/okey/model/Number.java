package okey.model;

public enum Number {
	one(1),
	two(2),
	three(3),
	four(4),
	five(5),
	six(6),
	seven(7),
	eight(8),
	nine(9),
	ten(10),
	eleven(11),
	twelve(12),
	thirteen(13);

	private final int value;

	private Number(int value) {
		this.value = value;
	}

	public static Number getEnum(int value) {
		for (Number durum : Number.values()) {
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



