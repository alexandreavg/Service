package br.com.servico.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	
	public boolean consultarCadastroIntegranteGrupo(IntegranteGrupo integranteGrupo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Session session = HibernateUtil.getFabricaDeSessoes().openSession();
			Query query = session.createQuery("from IntegranteGrupo where grupo_codigo = :grupo AND integrante_codigo = :integrante");
			query.setParameter("grupo", integranteGrupo.getGrupo());
			query.setParameter("integrante", integranteGrupo.getIntegrante());
			
			List<IntegranteGrupo> resultado = query.list();
			System.out.println("-------------------");
			for(IntegranteGrupo i: resultado) {
				System.out.println(i.getIntegrante() + " - " + i.getGrupo());
			}
			if(resultado.isEmpty()) {return false;}//não tem inculo usuário com codigo
			else {return true;}
			
		} catch (Exception e) {
			System.out.println("catch - Deu ruim!!!!!!!!!!!!!!!!!!!!!!!!!!");
			throw e;
		}  finally {
			sessao.close();
		}		
	}
	
}
