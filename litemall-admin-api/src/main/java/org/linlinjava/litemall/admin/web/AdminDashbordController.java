package org.linlinjava.litemall.admin.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.idgenerate.SingleServerIdGenerateService;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.service.LitemallGoodsProductService;
import org.linlinjava.litemall.db.service.LitemallGoodsService;
import org.linlinjava.litemall.db.service.LitemallOrderService;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dashboard")
@Validated
public class AdminDashbordController {
	private final Log logger = LogFactory.getLog(AdminDashbordController.class);

	@Autowired
	private LitemallUserService userService;
	@Autowired
	private LitemallGoodsService goodsService;
	@Autowired
	private LitemallGoodsProductService productService;
	@Autowired
	private LitemallOrderService orderService;

	@Autowired
	private SingleServerIdGenerateService idGenerateService;

	@GetMapping("")
	public Object info() {
		int userTotal = userService.count();
		int goodsTotal = goodsService.count();
		int productTotal = productService.count();
		int orderTotal = orderService.count();
		Map<String, Long> data = new HashMap<>();
		data.put("userTotal", (long) userTotal);
		data.put("goodsTotal", (long) goodsTotal);
		data.put("productTotal", (long) productTotal);
		data.put("orderTotal", (long) orderTotal);

		data.put("orderId", idGenerateService.incr("orderId", -1));

		return ResponseUtil.ok(data);
	}

}
