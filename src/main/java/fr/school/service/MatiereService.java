package fr.school.service;

import java.util.List;

import fr.school.model.Matiere;

public interface MatiereService {

	Matiere getId(long id);
	List<Matiere>getAllMatiere();
}
