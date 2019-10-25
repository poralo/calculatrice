package fr.pauleudeline.polocalc;

import java.util.List;

public interface IView {
	public void affiche();
	public void change(List<String> data);
	public void change(String accu);
}
