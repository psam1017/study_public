package com.example.ex00.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Outback")
public class Outback implements SteakHouse {

	@Override
	public boolean hasSaladBar() {
		return true;
	}
}
