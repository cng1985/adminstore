package com.haoxuer.adminstore.member.rest.resource;

import com.haoxuer.adminstore.member.api.apis.MemberApi;
import com.haoxuer.adminstore.member.api.domain.list.MemberList;
import com.haoxuer.adminstore.member.api.domain.page.MemberPage;
import com.haoxuer.adminstore.member.api.domain.request.*;
import com.haoxuer.adminstore.member.api.domain.response.MemberResponse;
import com.haoxuer.adminstore.member.data.dao.MemberDao;
import com.haoxuer.adminstore.member.data.entity.Member;
import com.haoxuer.adminstore.member.rest.convert.MemberResponseConvert;
import com.haoxuer.adminstore.member.rest.convert.MemberSimpleConvert;
import com.haoxuer.discover.config.utils.ConverResourceUtils;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.data.page.Order;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;
import com.haoxuer.discover.data.utils.FilterUtils;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.haoxuer.discover.user.rest.conver.PageableConver;
import com.haoxuer.discover.data.utils.BeanDataUtils;
import java.util.ArrayList;
import java.util.List;



@Transactional
@Component
public class MemberResource implements MemberApi {

    @Autowired
    private MemberDao dataDao;


    @Override
    public MemberResponse create(MemberDataRequest request) {
        MemberResponse result = new MemberResponse();

        Member bean = new Member();
        handleData(request, bean);
        dataDao.save(bean);
        result = new MemberResponseConvert().conver(bean);
        return result;
    }

    @Override
    public MemberResponse update(MemberDataRequest request) {
        MemberResponse result = new MemberResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        Member bean = dataDao.findById(request.getId());
        if (bean == null) {
            result.setCode(502);
            result.setMsg("无效id");
            return result;
        }
        handleData(request, bean);
        result = new MemberResponseConvert().conver(bean);
        return result;
    }

    private void handleData(MemberDataRequest request, Member bean) {
        BeanDataUtils.copyProperties(request,bean);

    }

    @Override
    public MemberResponse delete(MemberDataRequest request) {
        MemberResponse result = new MemberResponse();
        if (request.getId() == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        dataDao.deleteById(request.getId());
        return result;
    }

    @Override
    public MemberResponse view(MemberDataRequest request) {
        MemberResponse result=new MemberResponse();
        Member bean = dataDao.findById( request.getId());
        if (bean==null){
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        result=new MemberResponseConvert().conver(bean);
        return result;
    }
    @Override
    public MemberList list(MemberSearchRequest request) {
        MemberList result = new MemberList();

        List<Filter> filters = new ArrayList<>();
        filters.addAll(FilterUtils.getFilters(request));
        List<Order> orders = new ArrayList<>();
        if ("asc".equals(request.getSortMethod())){
           orders.add(Order.asc(""+request.getSortField()));
        }
        else if ("desc".equals(request.getSortMethod())){
           orders.add(Order.desc(""+request.getSortField()));
        }else{
           orders.add(Order.desc("id"));
        }
        List<Member> organizations = dataDao.list(0, request.getSize(), filters, orders);
        MemberSimpleConvert convert=new MemberSimpleConvert();
        ConverResourceUtils.converList(result, organizations,convert);
        return result;
    }

    @Override
    public MemberPage search(MemberSearchRequest request) {
        MemberPage result=new MemberPage();
        Pageable pageable = new PageableConver().conver(request);
        pageable.getFilters().addAll(FilterUtils.getFilters(request));
        if ("asc".equals(request.getSortMethod())){
            pageable.getOrders().add(Order.asc(""+request.getSortField()));
        }
        else if ("desc".equals(request.getSortMethod())){
            pageable.getOrders().add(Order.desc(""+request.getSortField()));
        }else{
            pageable.getOrders().add(Order.desc("id"));
        }
        Page<Member> page=dataDao.page(pageable);
        MemberSimpleConvert convert=new MemberSimpleConvert();
        ConverResourceUtils.converPage(result,page,convert);
        return result;
    }
}
