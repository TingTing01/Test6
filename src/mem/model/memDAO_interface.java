package mem.model;

import java.util.List;

public interface memDAO_interface {
	public void insert(memVO memvo);
	public void updata(memVO memvo);
	public void delete(memVO memvo);
	public List<memVO> findAll() ;

}
