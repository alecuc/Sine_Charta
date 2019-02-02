package control.storia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Abilita;
import beans.Personaggio;
import beans.Storia;
import beans.User;
import manager.AbilitaManager;
import manager.PersonaggioManager;
import manager.StoryManager;


/**
 * Servlet implementation class EditorStoriaServlet
 */
@WebServlet("/GestioneStoriaServlet")
public class GestioneStoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneStoriaServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String action= request.getParameter("action");
		Storia storia = new Storia();
		StoryManager str = new StoryManager();
		User user = (User)session.getAttribute("user");


		try {

			if(action.equalsIgnoreCase("inserisciPg")) {
				
				String param = (String)session.getAttribute("idStory"); 
				int idStory= Integer.parseInt(param);
				
				String nome, cognome, nazionalita, taroccoDominante, abiUso, abiPerc, abiFurt, abiUtil, abiGuida; 
					  int eta, intuito, aspetto, coordinazione, affinOcculta, memoria, comando, destrezza, distanzaDaMorte, percezione, creativita, forza, equilibrioMent, volonta, socievolezza, mira, karma, valUso,  valPerc, valFurt, valUtil, valGuida;
					      
				String pgData = (String) request.getParameter("dati");
				String[] attriPg = pgData.split(",");
				
					
				storia= str.getSimpleStory(idStory);
				
				
				int i = 0;
				nome = attriPg[i]; i++; 
				cognome = attriPg[i]; i++;
				eta = Integer.parseInt(attriPg[i]); i++; 
				nazionalita = attriPg[i]; i++; 
				taroccoDominante = attriPg[i]; i++; 
				
				intuito = Integer.parseInt(attriPg[i]);i++; 
				aspetto = Integer.parseInt(attriPg[i]); i++; 
				coordinazione= Integer.parseInt(attriPg[i]); i++; 
				affinOcculta= Integer.parseInt(attriPg[i]); i++; 
				memoria= Integer.parseInt(attriPg[i]); i++; 
				comando= Integer.parseInt(attriPg[i]); i++; 
				destrezza = Integer.parseInt(attriPg[i]); i++; 
				distanzaDaMorte= Integer.parseInt(attriPg[i]); i++; 
				percezione = Integer.parseInt(attriPg[i]); i++; 
				creativita= Integer.parseInt(attriPg[i]); i++; 
				forza = Integer.parseInt(attriPg[i]); i++; 
				equilibrioMent = Integer.parseInt(attriPg[i]); i++; 
				volonta = Integer.parseInt(attriPg[i]); i++; 
				socievolezza = Integer.parseInt(attriPg[i]); i++; 
				mira = Integer.parseInt(attriPg[i]); i++; 
				karma = Integer.parseInt(attriPg[i]); i++; 
				
				abiUso = attriPg[i]; i++; 
				valUso =Integer.parseInt(attriPg[i]);i++; 
				abiPerc = attriPg[i]; i++; 
				valPerc = Integer.parseInt(attriPg[i]);i++; 
				abiFurt = attriPg[i]; i++; 
				valFurt = Integer.parseInt(attriPg[i]);i++; 
				abiUtil = attriPg[i]; i++; 
				valUtil = Integer.parseInt(attriPg[i]);i++; 
				abiGuida = attriPg[i]; i++; 
				valGuida = Integer.parseInt(attriPg[i]);i++; 
				
				Personaggio pg = new Personaggio();

				pg.setNome(nome);
				pg.setCognome(cognome);
				pg.setAge(eta);
				pg.setNazionalita(nazionalita);
				pg.setTaroccoDominante(taroccoDominante);
				pg.setIntuito(intuito);
				pg.setAspetto(aspetto);
				pg.setCoordinazione(coordinazione);
				pg.setAffinOcculta(affinOcculta);
				pg.setMemoria(memoria);
				pg.setComando(comando);
				pg.setDestrManuale(destrezza);
				pg.setDistDaMorte(distanzaDaMorte);
				pg.setPercezione(percezione);
				pg.setCreativita(creativita);
				pg.setForzaFisica(forza);
				pg.setEquilibrMentale(equilibrioMent);
				pg.setVolonta(volonta);
				pg.setSocievolezza(socievolezza);
				pg.setMira(mira);
				pg.setKarma(karma);
				pg.setRisoluzione(karma+destrezza+coordinazione+volonta);
				pg.setFeritaTesta("-");
				pg.setFeritaTorso("-");
				pg.setFeritaBraccia("-");
				pg.setFeritaGambe("-");
				pg.setSalute(10);
				
				pg.setUser(user);
				pg.setUsername(user.getUsername());
				pg.setStoria(storia);
				pg.setIdStoria(idStory);


				
				PersonaggioManager pgM = new PersonaggioManager();
				pgM.creaPersonaggio(pg, idStory);
				
				AbilitaManager abM = new AbilitaManager();
				Abilita abi1 = new Abilita();		
				abi1.setNome(abiFurt);
				abi1.setValore(valFurt);
				abi1.setPersonaggio(pg);
				
				Abilita abi2 = new Abilita();
				abi2.setNome(abiGuida);
				abi2.setValore(valGuida);
				abi2.setPersonaggio(pg);
				
				Abilita abi3 = new Abilita();
				abi3.setNome(abiPerc);
				abi3.setValore(valPerc);
				abi3.setPersonaggio(pg);
				
				Abilita abi4 = new Abilita();
				abi4.setNome(abiUso);
				abi4.setValore(valUso);
				abi4.setPersonaggio(pg);
				
				Abilita abi5 = new Abilita();
				abi5.setNome(abiUtil);
				abi5.setValore(valUtil);
				abi5.setPersonaggio(pg);

				Set <Abilita> abSet= new HashSet<Abilita>();
				abSet.add(abi1);
				abSet.add(abi2);
				abSet.add(abi3);
				abSet.add(abi4);
				abSet.add(abi5);
				
				pg.aggiungiListaAbilita(abSet);
				
				abM.aggiungiAbilita(abi1, pg);
				abM.aggiungiAbilita(abi2, pg);
				abM.aggiungiAbilita(abi3, pg);
				abM.aggiungiAbilita(abi4, pg);
				abM.aggiungiAbilita(abi5, pg);
								
				session.setAttribute("nuovoPG", pg);
				
				response.setContentType("text/plain");
				response.getWriter().write("OK");
			}
			//questo if permette di prendere una storia in base ad un pg
			else if(action.equalsIgnoreCase("acquisireStoria"))	{


				
			//	Storia story = str.getSimpleStory(idStory);

				//session.setAttribute("storia", story);

				//questo if permette di inserire una storia nel database	
			}else if(action.equalsIgnoreCase("inserisciStoria")) {

				String nome = request.getParameter("Titolo");
				String descrizione = request.getParameter("Descrizione");
				String ambientazione = request.getParameter("Ambientazione");

				storia.setTitolo(nome);
				storia.setDescrizione(descrizione);
				storia.setAmbientazione(ambientazione);

				user.aggiungiStoria(storia);
				
				str.aggiungiStoria(storia);
				str.aggiungiATable(storia, user, 1);
				response.sendRedirect("jsp_page/riepilogoStoria(da vedere)");

				//questo if permette di prendere la lista delle storie
			}else if(action.equalsIgnoreCase("listaStorie")) {

				
				Collection<Storia>  listaStoria = str.getStoria(user);
				session.setAttribute("listaStorie", listaStoria);

				//questo if permette di fare un redirect alla pagina di creazione personaggio
			}else if(action.equalsIgnoreCase("creaPg")) {

				String param = request.getParameter("idStoria"); 

				
				session.setAttribute("idStory", param);
				response.sendRedirect("jsp_page/creazionePG.jsp");
				
				//questo if permette di inserire un pg	
			} 
		}catch (SQLException e) {
			e.printStackTrace();

		}catch (NullPointerException e) {
			response.sendRedirect("jsp_page/error/error.jsp");
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
