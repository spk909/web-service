package fr.school.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.school.dao.NoteDao;
import fr.school.model.Note;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Note getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		if (id == null){
			return new Note();
		}
		return  session.load(Note.class, id);
	}

	@Override
	public List<Note> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Note note = session.byId(Note.class).load(id);
		session.delete(note);
	}

	@Override
	public long save(Note note) {
		sessionFactory.getCurrentSession().save(note);
		return note.getId() ;
	}

}
