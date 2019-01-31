package control.storia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
		String idStoria = request.getParameter("idStoria"); 
		String action = request.getParameter("action");
		StoryManager str = new StoryManager();
		Storia storia = new Storia();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("username");
		Integer idStory = Integer.parseInt(idStoria);

		try {

			storia = (Storia)session.getAttribute("storia");

			//questo if permette di predere una storia in base ad un pg
			if(action.equalsIgnoreCase("acquisireStoria"))	{


				
				Storia story = str.getSimpleStory(idStory);

				session.setAttribute("storia", story);

				//questo if permette di inserire una storia nel database	
			}else if(action.equalsIgnoreCase("inserisciStoria")) {

				String nome = request.getParameter("Titolo");
				String descrizione = request.getParameter("Descrizione");
				String ambientazione = request.getParameter("Ambientazione");

				storia.setTitolo(nome);
				storia.setDescrizione(descrizione);
				storia.setAmbientazione(ambientazione);

				str.aggiungiStoria(storia, user);
				str.aggiungiATable(storia, user, 1);

				System.out.println("successfully inserted");
				response.sendRedirect("jsp_page/riepilogoStoria(da vedere)");

				//questo if permette di prendere la lista delle storie
			}else if(action.equalsIgnoreCase("listaStorie")) {

				User usr = (User)session.getAttribute("user");
				Collection<Storia>  listaStoria = str.getStoria(usr);
				session.setAttribute("listaStorie", listaStoria);

				//questo if permette di fare un redirect alla pagina di creazione personaggio
			}else if(action.equalsIgnoreCase("creaPg")) {

				String idSto = request.getParameter("idStoria");
				Integer idS = Integer.parseInt(idSto);
				session.setAttribute("idStory", idS);
				response.sendRedirect("jsp_page/creazionePG.jsp");
				
				//questo if permette di inserire un pg	
			}else if(action.equalsIgnoreCase("inserisciPg"));
				String nome, cognome, nazionalita, taroccoDominante, abiUso, abiPerc, abiFurt, abiUtil, abiGuida; 
					  int risoluzione, eta, intuito, aspetto, coordinazione, affinOcculta, memoria, comando, destrezza, distanzaDaMorte, percezione, creativita, forza, equilibrioMent, volonta, socievolezza, mira, karma, valUso,  valPerc, valFurt, valUtil, valGuida;
					      
				String pgData = (String) request.getAttribute("data");
				String[] attriPg = pgData.split(",");
				
				int i = 0;
				System.out.println("l'array è lungo:" + attriPg.length);
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
				risoluzione= Integer.parseInt(attriPg[i]);
				
				System.out.println("il valore di i alla fine degli assegnamenti è: " + i);
				
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
				pg.setRisoluzione(risoluzione);
				pg.setFeritaTesta("-");
				pg.setFeritaTorso("-");
				pg.setFeritaBraccia("-");
				pg.setFeritaGambe("-");
				PersonaggioManager pgM = new PersonaggioManager();
				
				pgM.creaPersonaggio(pg, 1);
				
				AbilitaManager abM = new AbilitaManager();
				Abilita abilita = new Abilita();		
				abilita.setNome(abiFurt);
				abilita.setValore(valFurt);
				Abilita abi2 = new Abilita();
				abi2.setNome(abiGuida);
				abi2.setValore(valGuida);
				Abilita abi3 = new Abilita();
				abi3.setNome(abiPerc);
				abi3.setValore(valPerc);
				Abilita abi4 = new Abilita();
				abi4.setNome(abiUso);
				abi4.setValore(valUso);
				Abilita abi5 = new Abilita();
				abi5.setNome(abiUtil);
				abi5.setValore(valUtil);
				
				abM.aggiungiAbilita(abilita, pg);
				abM.aggiungiAbilita(abi2, pg);
				abM.aggiungiAbilita(abi3, pg);
				abM.aggiungiAbilita(abi4, pg);
				abM.aggiungiAbilita(abi5, pg);
				System.out.println(pg.toString());
				
				session.setAttribute("nuovoPG", pg);
				
				response.sendRedirect("jsp_page/riepilogoPG.jsp");
				
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
