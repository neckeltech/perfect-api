package tech.neckel.perfectApi.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('RO_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        roleService.deleteById(id);
    }

}
