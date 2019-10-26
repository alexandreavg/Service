package br.com.servico.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.servico.domain.IntegranteGrupo;
import br.com.servico.domain.Usuario;
import br.com.servico.util.HibernateUtil;

public class IntegranteGrupoDAO extends GenericDAO<IntegranteGrupo> {
	
	/**
	 * @author Alexandre V. Garcia
	 * @param JSON USUARIO
	 * @return
	 * 
	 * Metodo que retorna todos os grupos que um usuario esta inscrito.
	 */
	@SuppressWarnings("unchecked")
	public List<IntegranteGrupo> listarPorIntegrante(Usuario integrante){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(IntegranteGrupo.class);
			
			consulta.add(Restrictions.eq("integrante.codigo", integrante.getCodigo()));
			
			List<IntegranteGrupo> resultado = consulta.list();
			
			return resultado;
			
		} catch (Exception e) {
			throw e;
		}  finally {
			sessao.close();
		}
		
	}
	
}
