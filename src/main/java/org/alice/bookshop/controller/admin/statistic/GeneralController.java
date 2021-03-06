package org.alice.bookshop.controller.admin.statistic;

import org.alice.bookshop.service.admin.statistic.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("asGeneralController")
public class GeneralController {

	@Autowired
	private GeneralService generalService;

	@GetMapping("/admin/statistic/general")
	public String general(Model model) {

		model.addAttribute("account", generalService.getNumberOfUser());
		model.addAttribute("blockedAccount", generalService.getNumberOfBlockedUser());

		model.addAttribute("totalBook", generalService.getTotalBook());
		model.addAttribute("deleteBook", generalService.getDeleteBook());
		model.addAttribute("remainBook", generalService.getRemainBook());
		model.addAttribute("totalRemainBook", generalService.getTotalRemainBook());

		model.addAttribute("order", generalService.getNumberOfOrder());
		model.addAttribute("newOrder", generalService.getNumberOfNewOrder());
		model.addAttribute("delevering", generalService.getNumberOfDelevering());
		model.addAttribute("successed", generalService.getNumberOfSuccessedOrder());
		model.addAttribute("canceled", generalService.getNumberOfCanceledOrder());

		model.addAttribute("author", generalService.getNumberOfAuthor());
		model.addAttribute("publisher", generalService.getNumberOfPublisher());
		model.addAttribute("categories", generalService.getNumberOfCategory());
		model.addAttribute("input", generalService.getNumberOfInput());
		model.addAttribute("sale", generalService.getNumberOfSale());
		return "/admin/statistic/general";
	}
}
