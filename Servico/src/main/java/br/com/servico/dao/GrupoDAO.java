package br.com.servico.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.servico.domain.Grupo;
import br.com.servico.util.HibernateUtil;

public class GrupoDAO extends GenericDAO<Grupo> {
	
	/**
	 * @author Alexandre V. Garcia
	 * @param nomeModerador
	 * @return
	 * 
	 * Metodo para retornar todos os grupos por nome do Moderador.
	 */
	@SuppressWarnings("unchecked")
	public List<Grupo> listarGrupoPorModerador(String nomeModerador){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Grupo.class);
			
			consulta.createAlias("usuario", "u");
			
			consulta.add(Restrictions.or(	Restrictions.ilike("u.nome", 		nomeModerador, MatchMode.ANYWHERE),
											Restrictions.ilike("u.sobreNome", nomeModerador, MatchMode.ANYWHERE)));
			
			List<Grupo> resultado = consulta.list();
			
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
		
	}

}
