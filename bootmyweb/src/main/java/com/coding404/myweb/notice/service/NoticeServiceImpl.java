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
import com.coding404.myweb.entity.QNotice;
import com.coding404.myweb.user.service.UserMapper;
import com.coding404.myweb.util.page.Criteria;
import com.coding404.myweb.util.page.PageDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

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
	public PageDTO<Notice> getList(Criteria cri) {

		Pageable pageable = PageRequest.of( cri.getPage() - 1,
											cri.getAmount(),
											Sort.by("nno").descending() ); 

		//동적쿼리를 만듬.
		QNotice qNotice = QNotice.notice;
		
		//조건을 조합할 불린빌더
		BooleanBuilder builder = new BooleanBuilder();
		
		//ID에 값이 있다면? express로 표현
		//cri의 writer가 공백이 아니거나 null이 아닐때
		if( cri.getWriter() != null && !cri.getWriter().equals("") ) {
			BooleanExpression express = qNotice.writer.like("%" + cri.getWriter() + "%" );
			builder.and(express); //or and
		}
		
		if( cri.getTitle() != null && !cri.getTitle().equals("") ) {
			BooleanExpression express = qNotice.title.like("%" + cri.getTitle() + "%" );
			builder.and(express);
		}
		
		if( cri.getContent() != null && !cri.getContent().equals("") ) {
			BooleanExpression express = qNotice.content.like("%" + cri.getContent() + "%" );
			builder.and(express);
		}
		
		//조회
		//Page<Notice> result = noticeRepository.findAll(pageable);
		Page<Notice> result = noticeRepository.findAll(builder, pageable);
		
		//페이지네이션 처리
		PageDTO<Notice> pageDTO = new PageDTO<>(result);
		
		return pageDTO;
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
		Optional<Notice> result = noticeRepository.findById( notice.getNno() );
		if( result.isPresent() ) { //결과가 있음
			
			Notice n = result.get();
			n.setTitle( notice.getTitle() ); //화면에서 수정된 값을 엔티티값으로 변경
			n.setContent( notice.getContent() ); 
			
			return noticeRepository.save(n);
		}
		return null;
		
	}

	@Override
	public void noticeDelete(Long nno) {
		noticeRepository.deleteById(nno);
	}
	
	
}
