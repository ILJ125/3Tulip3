package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {

	//-------------------------------------------------------------------
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 3;	// 한페이지당 레코드 수
	
	private static ListMessageService instance;
	
	public static ListMessageService	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new ListMessageService();
		}
		return instance;
	}
	
	private ListMessageService()
	{
		
	}
	public int getTotalCount() throws MessageException{
		MessageDao dao=MessageDao.getInstance();
		totalRecCount=dao.getTotalCount();
		pageTotalCount=totalRecCount/countPerPage;
		if(totalRecCount % countPerPage>0) pageTotalCount++;
		return pageTotalCount;
	}
	
	public List <Message> getMessageList(String pNum) throws MessageException
	{
		int pageNum=1;
		if(pNum != null) pageNum = Integer.parseInt(pNum);
		
		int firstRow = (pageNum-1)*countPerPage+1;
		int endRow=pageNum*countPerPage;
		
		// 전체 레코드를 검색해 온다면
		List <Message> mList = MessageDao.getInstance().selectList(firstRow,endRow);			
		return mList;
	}
	
	
}
