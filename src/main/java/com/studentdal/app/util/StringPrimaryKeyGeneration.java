package com.studentdal.app.util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

public class StringPrimaryKeyGeneration implements IdentifierGenerator{

// this is for verification primary key generation accuatlly its adding a prefix veri to primary keyy
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
	
		String prefix = "VER";
        Connection connection = (Connection) session.connection();

        try {
            Statement statement=((java.sql.Connection) connection).createStatement();

            ResultSet rs=statement.executeQuery("select count(id) as Id from reservation.verification");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return null;
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

    

}