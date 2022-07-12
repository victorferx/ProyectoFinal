package com.bootcamp.withdrawal.service.mapper;

import com.bootcamp.withdrawal.domain.Afp;
import com.bootcamp.withdrawal.domain.AfpCustomer;
import com.bootcamp.withdrawal.web.model.AfpCustomerModel;
import com.bootcamp.withdrawal.web.model.AfpModel;
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
public class AfpCustomerMapperImpl implements AfpCustomerMapper {

    @Override
    public AfpCustomer afpCustomerModelToAfpCustomer(AfpCustomerModel model) {
        if ( model == null ) {
            return null;
        }

        AfpCustomer.AfpCustomerBuilder afpCustomer = AfpCustomer.builder();

        afpCustomer.afp( afpModelToAfp( model.getAfp() ) );
        afpCustomer.amount( model.getAmount() );
        afpCustomer.bankAccount( model.getBankAccount() );
        afpCustomer.depositDate( model.getDepositDate() );
        afpCustomer.id( model.getId() );
        afpCustomer.identityCard( model.getIdentityCard() );

        return afpCustomer.build();
    }

    @Override
    public AfpCustomerModel afpCustomerToAfpCustomerModel(AfpCustomer domain) {
        if ( domain == null ) {
            return null;
        }

        AfpCustomerModel afpCustomerModel = new AfpCustomerModel();

        afpCustomerModel.setAfp( afpToAfpModel( domain.getAfp() ) );
        afpCustomerModel.setAmount( domain.getAmount() );
        afpCustomerModel.setBankAccount( domain.getBankAccount() );
        afpCustomerModel.setDepositDate( domain.getDepositDate() );
        afpCustomerModel.setId( domain.getId() );
        afpCustomerModel.setIdentityCard( domain.getIdentityCard() );

        return afpCustomerModel;
    }

    @Override
    public List<AfpCustomerModel> afpCustomersToAfpCustomerModels(List<AfpCustomer> domain) {
        if ( domain == null ) {
            return null;
        }

        List<AfpCustomerModel> list = new ArrayList<AfpCustomerModel>( domain.size() );
        for ( AfpCustomer afpCustomer : domain ) {
            list.add( afpCustomerToAfpCustomerModel( afpCustomer ) );
        }

        return list;
    }

    @Override
    public void update(AfpCustomer entity, AfpCustomerModel updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        if ( updateEntity.getAfp() != null ) {
            if ( entity.getAfp() == null ) {
                entity.setAfp( Afp.builder().build() );
            }
            afpModelToAfp1( updateEntity.getAfp(), entity.getAfp() );
        }
        else {
            entity.setAfp( null );
        }
        entity.setAmount( updateEntity.getAmount() );
        entity.setBankAccount( updateEntity.getBankAccount() );
        entity.setDepositDate( updateEntity.getDepositDate() );
        entity.setIdentityCard( updateEntity.getIdentityCard() );
    }

    protected Afp afpModelToAfp(AfpModel afpModel) {
        if ( afpModel == null ) {
            return null;
        }

        Afp.AfpBuilder afp = Afp.builder();

        afp.id( afpModel.getId() );
        afp.name( afpModel.getName() );

        return afp.build();
    }

    protected AfpModel afpToAfpModel(Afp afp) {
        if ( afp == null ) {
            return null;
        }

        AfpModel afpModel = new AfpModel();

        afpModel.setId( afp.getId() );
        afpModel.setName( afp.getName() );

        return afpModel;
    }

    protected void afpModelToAfp1(AfpModel afpModel, Afp mappingTarget) {
        if ( afpModel == null ) {
            return;
        }

        mappingTarget.setId( afpModel.getId() );
        mappingTarget.setName( afpModel.getName() );
    }
}
