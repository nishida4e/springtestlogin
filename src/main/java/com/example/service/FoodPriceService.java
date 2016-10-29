package com.example.service;

import com.example.domain.FoodPrice;
import com.example.repository.FoodPriceJdbcRepository;
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
	//FoodPriceJdbcRepository fpRepo;

	public List<FoodPrice> findAll() {
		return fpRepo.findAll();
		//return fpRepo.findByNameContaining("カレー");
	}

	public FoodPrice findOne(Integer id) {
		return fpRepo.findOne(id);
	}

	public FoodPrice create(FoodPrice fp) {
		FoodPrice ret = fpRepo.save(fp);
		// fpRepo.rollbacktest();
		return ret;
	}

	public void delete(Integer id) {
		fpRepo.delete(id);
	}

}
