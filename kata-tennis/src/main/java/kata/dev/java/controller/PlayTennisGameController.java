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


import kata.dev.java.bean.TennisGame;
import kata.dev.java.rules.Rules;
import kata.dev.java.services.IServiceTennisGame;

@Controller
public class PlayTennisGameController {
	
	 @Autowired
	 private IServiceTennisGame service;
	 
	 
	 	@RequestMapping(value="/displayTennisGame", method = RequestMethod.GET)
	    public String afficher(final ModelMap pModel) {
	        final List<TennisGame> challenge = service.getAllTennisGame();
	 	        
	        pModel.addAttribute("challenge", challenge);
	       
	        if (pModel.get("creation") == null) {
	            pModel.addAttribute("creation", new CreationForm());
	        }
	        return "creation";
	    }

	    @RequestMapping(value="/playTennisGame", method = RequestMethod.POST)
	    public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation, 
	            final BindingResult pBindingResult, final ModelMap pModel) {

	        if (!pBindingResult.hasErrors()) {
	        	final Integer id = Integer.valueOf(pCreation.getId()); 
	        	List<TennisGame> temp = service.getAllTennisGame();	        	
	        	TennisGame game = Rules.addGame(id.intValue(), temp.get(temp.size()-1));
	        	service.createGameService(game);
	       	        	
	        	List<TennisGame> temp_ = service.getAllTennisGame();
	        	int index = temp_.get(temp_.size()-1).getIdSet();
	        		        	
	        	if(Rules.playerWinSet(service.searchTennisGameBySetIdService(index)).getWinner() == 1 ) {
	        		//TennisGame p1 = Rules.playerWinSet(service.getAllTennisGame()).getNewGame();
	        		System.out.println("Player 1 win Set " +index);
	        		service.createGameService(Rules.playerWinSet(temp_).getNewGame());      		
	           	}
	        	
	        	if(Rules.playerWinSet(service.searchTennisGameBySetIdService(index)).getWinner() == 2 ) {
	        		//TennisGame p2 = Rules.playerWinSet(service.getAllTennisGame()).getNewGame();
	        		System.out.println("Player 2 win Set " +index);
	        		service.createGameService(Rules.playerWinSet(temp_).getNewGame());     		
	           	}	        	
	        	
	        }	
	        
	        int challengerWinner = Rules.playerWinChallenge(service.getAllTennisGame().get(service.getAllTennisGame().size()-1));
	        if (challengerWinner == 1) System.out.println("Player 1 win Challenge");
	        if (challengerWinner == 2) System.out.println("Player 2 win Challenge");
	        
	        return afficher(pModel);
	    }	    

	    @RequestMapping(value="/deleteTennisGame", method = RequestMethod.GET)
	    public String delete(final ModelMap pModel) {
	    	
	    	List<TennisGame> temp = service.getAllTennisGame();
	    	if(temp.size() > 1)
	    		service.deleteLastGameService(temp.get(temp.size()-1).getIdGame());
	        return afficher(pModel);
	    }
}
