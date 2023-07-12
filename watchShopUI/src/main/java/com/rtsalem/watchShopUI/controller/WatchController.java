package com.rtsalem.watchShopUI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rtsalem.watchShopUI.model.Watch;
import com.rtsalem.watchShopUI.service.WebClientWatchService;

@Controller
public class WatchController {

	private WebClientWatchService watchService;

	public WatchController(WebClientWatchService watchService) {
		super();
		this.watchService = watchService;
	}

	@RequestMapping("allWatches")
	public String getAllWatches(Model model) {
		model.addAttribute("listOfWatches", watchService.findAllWatches());
		return "all-watches";
	}

	@RequestMapping("addWatch")
	public String addWatch(Model model) {
		model.addAttribute("watch", new Watch());
		return "add-watch";
	}

	@PostMapping("addWatchSubmit")
	public String addWatchSubmit(@ModelAttribute Watch watch) {
		watchService.addWatch(watch);
		return "forward:/allWatches";
	}

	@GetMapping("updateWatch")
	public String updateWatch(Model model, @RequestParam int id) {
		model.addAttribute("watch", watchService.findWatchById(id));
		return "update-watch";
	}

	@PostMapping("updateWatchSubmit")
	public String updateWatchSubmit(@ModelAttribute Watch watch) {
		watchService.updateWatch(watch.getId(), watch);
		return "forward:/allWatches";
	}

	@GetMapping("deleteWatch")
	public String deleteWatch(@RequestParam int id) {
		watchService.deleteWatchById(id);
		return "forward:/allWatches";
	}

}
