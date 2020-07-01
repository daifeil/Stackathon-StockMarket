package com.smc.sba.controller;


import com.smc.sba.entity.StockExchangeEntity;
import com.smc.sba.service.ExchangeService;
import com.smc.sba.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin/manage/exchange")
public class StockExchangeController {

	@Autowired
	private ExchangeService exchangeService;

	/**
	 * create
	 * @param stcokExchange
	 * @return
	 */
	@PostMapping
	public CommonResult createExchange(@RequestBody StockExchangeEntity stcokExchange) {
		return exchangeService.save(stcokExchange);
	}

	/**
	 * update
	 * @param stcokExchange
	 * @return
	 */
	@PutMapping
	public CommonResult searchExchange(@RequestBody StockExchangeEntity stcokExchange) {
		return exchangeService.updateStockExchange(stcokExchange);
	}
}
