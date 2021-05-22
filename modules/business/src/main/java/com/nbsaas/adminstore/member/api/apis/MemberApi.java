package com.nbsaas.adminstore.member.api.apis;


import com.nbsaas.adminstore.member.api.domain.list.MemberList;
import com.nbsaas.adminstore.member.api.domain.page.MemberPage;
import com.nbsaas.adminstore.member.api.domain.request.*;
import com.nbsaas.adminstore.member.api.domain.response.MemberResponse;

public interface MemberApi {

    /**
     * 创建
     *
     * @param request
     * @return
     */
    MemberResponse create(MemberDataRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    MemberResponse update(MemberDataRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    MemberResponse delete(MemberDataRequest request);


    /**
    * 详情
    *
    * @param request
    * @return
    */
     MemberResponse view(MemberDataRequest request);


    /**
     * 集合功能
     * @param request
     * @return
     */
    MemberList list(MemberSearchRequest request);

    /**
     * 搜索功能
     *
     * @param request
     * @return
     */
    MemberPage search(MemberSearchRequest request);

}