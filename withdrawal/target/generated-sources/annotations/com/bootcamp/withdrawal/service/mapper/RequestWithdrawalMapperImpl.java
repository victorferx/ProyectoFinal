package com.bootcamp.withdrawal.service.mapper;

import com.bootcamp.withdrawal.domain.RequestWithdrawal;
import com.bootcamp.withdrawal.web.model.RequestWithdrawalModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T15:19:35-0500",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class RequestWithdrawalMapperImpl implements RequestWithdrawalMapper {

    @Override
    public RequestWithdrawal requestWithdrawalModelToRequestWithdrawal(RequestWithdrawalModel model) {
        if ( model == null ) {
            return null;
        }

        RequestWithdrawal.RequestWithdrawalBuilder requestWithdrawal = RequestWithdrawal.builder();

        requestWithdrawal.afpId( model.getAfpId() );
        requestWithdrawal.amount( model.getAmount() );
        requestWithdrawal.id( model.getId() );
        requestWithdrawal.identityCard( model.getIdentityCard() );

        return requestWithdrawal.build();
    }

    @Override
    public RequestWithdrawalModel requestWithdrawalToRequestWithdrawalModel(RequestWithdrawal domain) {
        if ( domain == null ) {
            return null;
        }

        RequestWithdrawalModel requestWithdrawalModel = new RequestWithdrawalModel();

        requestWithdrawalModel.setAfpId( domain.getAfpId() );
        requestWithdrawalModel.setAmount( domain.getAmount() );
        requestWithdrawalModel.setId( domain.getId() );
        requestWithdrawalModel.setIdentityCard( domain.getIdentityCard() );

        return requestWithdrawalModel;
    }

    @Override
    public List<RequestWithdrawalModel> requestWithdrawalsToRequestWithdrawalModels(List<RequestWithdrawal> domain) {
        if ( domain == null ) {
            return null;
        }

        List<RequestWithdrawalModel> list = new ArrayList<RequestWithdrawalModel>( domain.size() );
        for ( RequestWithdrawal requestWithdrawal : domain ) {
            list.add( requestWithdrawalToRequestWithdrawalModel( requestWithdrawal ) );
        }

        return list;
    }

    @Override
    public void update(RequestWithdrawal entity, RequestWithdrawalModel updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setAfpId( updateEntity.getAfpId() );
        entity.setAmount( updateEntity.getAmount() );
        entity.setIdentityCard( updateEntity.getIdentityCard() );
    }
}
