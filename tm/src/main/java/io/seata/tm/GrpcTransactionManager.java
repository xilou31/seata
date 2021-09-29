package io.seata.tm;

import io.seata.core.exception.TransactionException;
import io.seata.core.model.GlobalStatus;
import io.seata.core.model.TransactionManager;
import io.seata.core.model.grpc.SeataGrpc.GlobalBeginRequest;
import io.seata.core.model.grpc.SeataGrpc.GlobalCommitRequest;
import io.seata.core.model.grpc.SeataGrpc.GlobalReportRequest;
import io.seata.core.model.grpc.SeataGrpc.GlobalRollbackRequest;
import io.seata.core.model.grpc.SeataGrpc.GlobalSession;
import io.seata.core.model.grpc.SeataGrpc.GlobalStatusRequest;
import io.seata.core.rpc.grpc.TmGrpcRemotingClient;

/**
 * @author xilou31
 **/
public class GrpcTransactionManager implements TransactionManager {
    @Override
    public String begin(String applicationId, String transactionServiceGroup, String name, int timeout) throws TransactionException {
        GlobalBeginRequest request = GlobalBeginRequest.newBuilder()
                .setAddressing(transactionServiceGroup)
                .setTransactionName(name)
                .setTimeout(timeout)
                .build();
    }

    @Override
    public GlobalStatus commit(String xid) throws TransactionException {
        GlobalCommitRequest request = GlobalCommitRequest.newBuilder()
                .setXID(xid)
                .build();
        return GlobalStatus.valueOf(TmGrpcRemotingClient.getInstance()
                .commit(request)
                .getGlobalStatus()
                .name());
    }

    @Override
    public GlobalStatus rollback(String xid) throws TransactionException {
        GlobalRollbackRequest request = GlobalRollbackRequest.newBuilder()
                .setXID(xid)
                .build();
        return GlobalStatus.valueOf(TmGrpcRemotingClient.getInstance()
                .rollback(request)
                .getGlobalStatus()
                .name());
    }

    @Override
    public GlobalStatus getStatus(String xid) throws TransactionException {
        GlobalStatusRequest request = GlobalStatusRequest.newBuilder()
                .setXID(xid)
                .build();
        return GlobalStatus.valueOf(TmGrpcRemotingClient.getInstance()
                .getStatus(request)
                .getGlobalStatus()
                .name());
    }

    @Override
    public GlobalStatus globalReport(String xid, GlobalStatus globalStatus) throws TransactionException {
        GlobalReportRequest request = GlobalReportRequest.newBuilder()
                .setXID(xid)
                .setGlobalStatus(GlobalSession.GlobalStatus.valueOf(globalStatus.name()))
                .build();
        return GlobalStatus.valueOf(TmGrpcRemotingClient.getInstance()
                .globalReport(request)
                .getGlobalStatus()
                .name());
    }
}
