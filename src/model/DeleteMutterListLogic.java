package model;

import dao.MutterDAO;

public class DeleteMutterListLogic {
	 public void execute(String mutterId) {
		 MutterDAO dao = new MutterDAO();
		 dao.remove(mutterId);
	 }


}
