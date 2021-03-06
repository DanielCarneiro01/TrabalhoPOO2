/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cgd;

import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.jogador.JogadorHumano;
import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bassini
 */
public class PartidaDAO extends DAOGeneric implements DAO<Partida> {

    public void criarTabela() throws ClassNotFoundException, SQLException
    {
            this.openConnection();

            this.execute("DROP TABLE IF EXISTS PARTIDA;");

            String sql =    " CREATE TABLE IF NOT EXISTS PARTIDA " +
                            " (ID INTEGER GENERATED BY DEFAULT AS IDENTITY "+
                            " (START WITH 1, INCREMENT BY 1) NOT NULL, " +
                            " PARTIDAS OBJECT, "+
                            " PRIMARY KEY (ID))";

            this.execute(sql);

            this.closeConnection();
    }
    
    public Partida create() {
            return new Partida();
    }
    
    public void insert(Partida obj) throws SQLException, ClassNotFoundException {
		
		this.openConnection();
                byte[] teste=null;
                try {
                      teste = serialize(obj);
                } catch (IOException ex) {
                    Logger.getLogger(PartidaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                        
		String sql  = "INSERT INTO PARTIDA(PARTIDAS)"
                            + " VALUES ("+ (teste) +")"; 
		
		int id = this.executeUpdate(sql);
		obj.setId(id);
                this.closeConnection();
                
                //this.update(obj);
		
	}
        
        public void update(Partida obj) throws SQLException, ClassNotFoundException {
            
            this.openConnection();
            
            String sql = "UPDATE PARTIDA SET( PARTIDAS="+(obj)+") WHERE ID="+obj.getId()+"";
            
            int id = this.executeUpdate(sql);
		
            this.closeConnection();
            
            
	}

        

        public void delete(Partida obj) throws SQLException, ClassNotFoundException {
            this.openConnection();
            
            String sql = "DELETE FROM PARTIDA WHERE ID="+obj.getId()+"";
            
            int id = this.executeUpdate(sql);
		
            this.closeConnection();
        }

        public Partida findbyID(Long id) throws SQLException, ClassNotFoundException {
            this.openConnection();
		
            String sql = "SELECT * FROM PARTIDA WHERE ID ="+id;
		
            ResultSet rs = this.executeQuery(sql);
            
            Partida partida = null;
            if(rs.first()){
               
                partida = rs.getObject("PARTIDAS",Partida.class);
                
            }
            return partida;
            
        }
        
        

        public List<Partida> findAll() throws SQLException, ClassNotFoundException {
            
            this.openConnection();
		
		String sql = "SELECT * FROM PARTIDA";
		
                
                List<Partida> lista = new ArrayList<Partida>();
		
		
		ResultSet rs = this.executeQuery(sql);
		
		while (rs.next())
		{   
                    Partida partida =null;
                    
                    partida = rs.getObject("PARTIDAS",Partida.class);
                    lista.add(partida);
                    
                    
		}
		
		
		this.closeConnection();
		
		return lista;
        }
        
        
        
        
        public static byte[] serialize(Object obj) throws IOException {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(obj);
            return out.toByteArray();
        }
        public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            return is.readObject();
        }
        
    
}
