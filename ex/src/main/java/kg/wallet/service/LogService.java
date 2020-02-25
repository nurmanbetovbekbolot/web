package kg.wallet.service;

import kg.wallet.dao.LogDao;
import kg.wallet.model.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/logs")
public class LogService {
    private LogDao logDao = new LogDao();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Log> getAllLogs() {
        return logDao.getLogs();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Log createLog(Log log) {
        return logDao.createLog(log);
    }

    @DELETE
    @Path("/{logId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteLog(@PathParam("logId") Integer logId) {
        logDao.deleteLogById(logId);
    }

}
