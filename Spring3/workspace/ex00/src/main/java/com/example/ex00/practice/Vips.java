package com.example.ex00.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Vips")
@Primary
public class Vips implements SteakHouse {

	@Override
	public boolean hasSaladBar() {
		return false;
	}
}
