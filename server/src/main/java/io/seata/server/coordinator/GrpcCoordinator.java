package io.seata.server.coordinator;

import io.grpc.stub.StreamObserver;
import io.seata.core.exception.TransactionException;
import io.seata.core.model.grpc.SeataGrpc;
import io.seata.core.model.grpc.TransactionManagerServiceGrpc.TransactionManagerServiceImplBase;
import io.seata.core.protocol.transaction.BranchRegisterRequest;
import io.seata.core.protocol.transaction.BranchRegisterResponse;
import io.seata.core.protocol.transaction.BranchReportRequest;
import io.seata.core.protocol.transaction.BranchReportResponse;
import io.seata.core.protocol.transaction.GlobalLockQueryRequest;
import io.seata.core.protocol.transaction.GlobalLockQueryResponse;
import io.seata.core.protocol.transaction.GlobalReportRequest;
import io.seata.core.protocol.transaction.GlobalReportResponse;
import io.seata.core.protocol.transaction.GlobalRollbackRequest;
import io.seata.core.protocol.transaction.GlobalRollbackResponse;
import io.seata.core.protocol.transaction.GlobalStatusRequest;
import io.seata.core.protocol.transaction.GlobalStatusResponse;
import io.seata.core.rpc.RpcContext;

/**
 * @author xilou
 * @date 2021/9/29
 **/
public class GrpcCoordinator extends TransactionManagerServiceImplBase {
    @Override
    public void begin(SeataGrpc.GlobalBeginRequest request, StreamObserver<SeataGrpc.GlobalBeginResponse> responseObserver) {
        super.begin(request, responseObserver);
    }

    @Override
    public void commit(SeataGrpc.GlobalCommitRequest request, StreamObserver<SeataGrpc.GlobalCommitResponse> responseObserver) {
        super.commit(request, responseObserver);
    }

    @Override
    public void rollback(SeataGrpc.GlobalRollbackRequest request, StreamObserver<SeataGrpc.GlobalRollbackResponse> responseObserver) {
        super.rollback(request, responseObserver);
    }

    @Override
    protected void doGlobalRollback(GlobalRollbackRequest request, GlobalRollbackResponse response, RpcContext rpcContext) throws TransactionException {

    }

    @Override
    protected void doBranchRegister(BranchRegisterRequest request, BranchRegisterResponse response, RpcContext rpcContext) throws TransactionException {

    }

    @Override
    protected void doBranchReport(BranchReportRequest request, BranchReportResponse response, RpcContext rpcContext) throws TransactionException {

    }

    @Override
    protected void doLockCheck(GlobalLockQueryRequest request, GlobalLockQueryResponse response, RpcContext rpcContext) throws TransactionException {

    }

    @Override
    protected void doGlobalStatus(GlobalStatusRequest request, GlobalStatusResponse response, RpcContext rpcContext) throws TransactionException {

    }

    @Override
    protected void doGlobalReport(GlobalReportRequest request, GlobalReportResponse response, RpcContext rpcContext) throws TransactionException {

    }
}
