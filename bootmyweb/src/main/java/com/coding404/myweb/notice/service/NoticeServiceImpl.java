package com.coding404.myweb.notice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.coding404.myweb.entity.Notice;
import com.coding404.myweb.user.service.UserMapper;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	//마이바티스 영역으로 붙일려면
	//@Autowired
	//UserMapper userMapper;
	
	@Autowired
	NoticeRepository noticeRepository;

	@Override
	public Notice noticeReg(Notice notice) {
		return noticeRepository.save(notice);
	}

	@Override
	public List<Notice> getList() {
		return noticeRepository.findAll( Sort.by("nno").descending() );
	}

	@Override
	public Notice getDetail(Long nno) {
		
		Optional<Notice> result = noticeRepository.findById(nno);
		
		if(result.isPresent() ) { //있다면 true
			Notice notice = result.get();
			return notice;
		}
		return null; //없다면 null반환
	}

	@Override
	public List<Notice> getListMe(String writer) {
		
		/*
		 * 1. NoticeRepository - 쿼리메서드 or JPQL구문을 생성합니다
		 * 2. sql = SELECT * FROM notice where writer = ?
		 * 3. 메서드를 실행시켜서 List<Notice>값을 반환받습니다.
		 * + 조건 마지막매개변수로 pageable를 받아서 10개의 데이터를 조회 하도록 처리.
		 * 
		 * 4. 컨트롤러에서 모델에 담아서 화면에선 처리해주면 됩니다.
		 */
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("nno").descending() );
		
		Page<Notice> result = noticeRepository.getListMe(writer, pageable);
		
		return result.getContent();
	}

	@Override
	public Notice noticeUpdate(Notice notice) {
		//조회한 결과를 가지고 있다면, save메서드를 이용해서 update수행
		Optional<Notice> result = noticeRepository.findById(notice.getNno());
		if(result.isPresent()) {
			Notice n = result.get();
			n.setTitle(notice.getTitle());
			n.setContent(notice.getContent());
			return noticeRepository.save(n);
		}
		return null;
	}

	@Override
	public void noticeDelete(Long nno) {
		// TODO Auto-generated method stub
		noticeRepository.deleteById(nno);
	}
	
	
}
