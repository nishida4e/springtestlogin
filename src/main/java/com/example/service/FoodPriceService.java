package com.example.service;

import com.example.domain.FoodPrice;
import com.example.domain.User;
import com.example.repository.FoodPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodPriceService {

	@Autowired
	FoodPriceRepository fpRepo;

	public List<FoodPrice> findAll() {
		return fpRepo.findAll();
	}

	public FoodPrice findOne(Integer id) {
		return fpRepo.findOne(id);
	}

	public FoodPrice create(FoodPrice fp, User user) {
		fp.setUser(user);
		FoodPrice ret = fpRepo.save(fp);
		return ret;
	}

	public void delete(Integer id) {
		fpRepo.delete(id);
	}

}
