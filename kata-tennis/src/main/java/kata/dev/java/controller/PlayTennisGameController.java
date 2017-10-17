package kata.dev.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kata.dev.java.bean.TennisMatch;
import kata.dev.java.rules.Play;
import kata.dev.java.rules.Rules;
import kata.dev.java.services.IServiceTennisGame;

@Controller
public class PlayTennisGameController {
	
	 @Autowired
	 private IServiceTennisGame service;
	 
	 
	 	@RequestMapping(value="/displayTennisGame", method = RequestMethod.GET)
	    public String display(final ModelMap pModel) {
	        final List<TennisMatch> challenge = service.getAllTennisPlayService();
	        final List<Object[]> games = service.getAllTennisGameService();
	        pModel.addAttribute("challenge", challenge);       
	        pModel.addAttribute("games", games);
	  	       
	        if (pModel.get("creation") == null) {
	            pModel.addAttribute("creation", new CreationForm());
	        }
	        return "creation";
	    }

	    @RequestMapping(value="/playTennisGame", method = RequestMethod.POST)
	    public String create(@Valid @ModelAttribute(value="creation") final CreationForm pCreation, 
	            final BindingResult pBindingResult, final ModelMap pModel) {

	        if (!pBindingResult.hasErrors()) {
	        	final Integer id = Integer.valueOf(pCreation.getId()); 
	        	List<TennisMatch> temp = service.getAllTennisPlayService();	      
	        	Play p = Rules.addPlayDEUCE(id, temp.get(temp.size()-1));
	        	service.createPlayService(p.getPlay());	        	
	        	
	        	
	        	if(p.getWinner() == 1)
	        		System.out.println("Player 1 win Game " +(p.getPlay().getIdGame()-1));
	        	
	        	if(p.getWinner() == 2)
	        		System.out.println("Player 2 win Game " +(p.getPlay().getIdGame()-1)); 	
	        	
	        }	
	        
	        int matchWinner = Rules.playerWinSetWithTB(service.getAllTennisPlayService().get(service.getAllTennisPlayService().size()-1));
	        if (matchWinner == 1) {
	        	System.out.println("Player 1 win Match");
	        	return matchEnd(pModel, 1);
	        }
	        if (matchWinner == 2) {
	        	System.out.println("Player 2 win Match");
	        	return matchEnd(pModel, 2);
	        }
	        
	        return display(pModel);
	    }	    

	    @RequestMapping(value="/deleteTennisGame", method = RequestMethod.POST)
	    public String delete(final ModelMap pModel, @ModelAttribute(value="creation") final CreationForm pId) {
	    	
	    	final Integer id = Integer.valueOf(pId.getId()); 
	    	
	    	if(id.intValue() == 4)
	    		service.deleteAllPlayService();
	    	
	    	if(id.intValue() == 3){
	    		List<TennisMatch> temp = service.getAllTennisPlayService();
		    	if(temp.size() > 1)
		    		service.deleteLastPlayService(temp.get(temp.size()-1).getIdPlay());	    		
	    	}
	    	return display(pModel);
	    }
	    
	    @RequestMapping(value="/end", method = RequestMethod.GET)
	    public String matchEnd(final ModelMap pModel, int winner) {	    	
	    	 pModel.addAttribute("winner", winner);
	         return "matchend";
	    }
}
