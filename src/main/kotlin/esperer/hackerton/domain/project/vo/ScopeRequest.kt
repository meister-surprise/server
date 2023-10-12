package esperer.hackerton.domain.project.vo

import esperer.hackerton.domain.project.Scope
import org.springframework.web.bind.annotation.RequestParam

data class ScopeRequest(
    val scope: Scope = Scope.PUBLIC
)
