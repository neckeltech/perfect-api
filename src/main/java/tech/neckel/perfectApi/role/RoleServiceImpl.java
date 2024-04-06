package tech.neckel.perfectApi.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
