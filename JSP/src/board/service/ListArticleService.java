package board.service;

import java.util.List;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;
import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

public class ListArticleService {
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ListArticleService instance;
	public static ListArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ListArticleService();
		}
		return instance;
	}
	public int getTotalCount() throws BoardException{
		BoardDao dao=BoardDao.getInstance();
		totalRecCount=dao.getTotalCount();
		pageTotalCount=totalRecCount/countPerPage;
		if(totalRecCount % countPerPage>0) pageTotalCount++;
		return pageTotalCount;
	}
	public List <BoardRec> getArticleList(String pNum) throws BoardException
	{
		int pageNum=1;
		if(pNum != null) pageNum = Integer.parseInt(pNum);
		
		int firstRow = (pageNum-1)*countPerPage+1;
		int endRow=pageNum*countPerPage;
		
		// 전체 레코드를 검색해 온다면
		List <BoardRec> mList = BoardDao.getInstance().selectList(firstRow, endRow);		
		return mList;
	}
	
	public List <BoardRec> getArticleList() throws BoardException
	{
		// 
		 List <BoardRec> mList = BoardDao.getInstance().selectList();			
		return mList;
	}
		
}
