

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.wavemaker.runtime.security.SecurityService;
public class ApplyLeaveServiceTest
{   @Mock
     private Employee emp;
    
    @Mock
    private Vacation vac;
    
    @Mock
    private VacationService vacs;
    
    @Mock
    private SecurityService securityService;
    @Mock
    private EmployeeService emps;
    
    @Mock
    private HrdbQueryExecutorService hqs;
    
    @InjectMocks
    private ApplyLeaveService als;
    
    @Test
    public void applyLeaveTest()
    {   emp.setLeaveBalance(6);
        when(securityService.getLoggedInUser().getUserId())).thenReturn(1);
        when(emps.getById(anyInt())).thenReturn(emp);
        when(hqs.executeApplyLeave(applyLeaveRequest).thenReturn("Leave Applied");
        when(emps.update(emp)).thenReturn("LeaveBalance Updated");
        
        als.applyLeave(new Date(),new Date(),"Personal Leave");
        
    }
   
}
