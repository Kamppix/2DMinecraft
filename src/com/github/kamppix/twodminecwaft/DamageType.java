package com.github.kamppix.twodminecwaft;

import com.github.kamppix.twodminecwaft.sounds.Sound;
import com.github.kamppix.twodminecwaft.sounds.Sounds;

public class DamageType {
	
	public static final DamageType GENERIC = new DamageType(Sounds.TEST);
	public static final DamageType FALL = new DamageType(Sounds.TEST);
	public static final DamageType DROWN = new DamageType(Sounds.TEST);
	public static final DamageType BURN = new DamageType(Sounds.TEST);

	@SuppressWarnings("unused")
	private Sound sound;

	public DamageType(Sound sound) {
		this.sound = sound;
	}
}
